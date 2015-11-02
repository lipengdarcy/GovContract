package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfOutline;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * http://rensanning.iteye.com/blog/1538689
 * 
 * */
public class PdfTest {

	public static void main(String[] args) throws FileNotFoundException,
			DocumentException {
		simpleTest();
		simpleTest2();
	}

	/**
	 * 1、生成一个PDF
	 * */
	public static void simpleTest() throws FileNotFoundException,
			DocumentException {
		// Step 1—Create a Document.
		Document document = new Document();
		// Step 2—Get a PdfWriter instance.
		PdfWriter.getInstance(document, new FileOutputStream(
				"createSamplePDF.pdf"));
		// Step 3—Open the Document.
		document.open();
		// Step 4—Add content.
		document.add(new Paragraph("Hello World"));
		// Step 5—Close the Document.
		document.close();

	}

	/**
	 * 1、2、页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * */
	public static void simpleTest2() throws FileNotFoundException,
			DocumentException {

		// 属性设置开始
		// 页面大小
		Rectangle rect = new Rectangle(PageSize.B5.rotate());
		// 页面背景色
		rect.setBackgroundColor(BaseColor.ORANGE);

		Document doc = new Document(rect);
		FileOutputStream out = new FileOutputStream("PDFPageAttributes.pdf");

		PdfWriter writer = PdfWriter.getInstance(doc, out);
		// PDF版本(默认1.4)
		writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

		// 文档属性
		doc.addTitle("Title@sample");
		doc.addAuthor("Author@rensanning");
		doc.addSubject("Subject@iText sample");
		doc.addKeywords("Keywords@iText");
		doc.addCreator("Creator@iText");
		// 页边空白
		doc.setMargins(10, 20, 30, 40);
		doc.open();
		doc.add(new Paragraph("Hello World"));
		// 属性设置结束

		// 设置目录开始
		doc.add(new Chunk("Chapter 1").setLocalDestination("1"));
		doc.newPage();
		doc.add(new Chunk("Chapter 2").setLocalDestination("2"));
		doc.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));
		doc.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));

		doc.newPage();
		doc.add(new Chunk("Chapter 3").setLocalDestination("3"));

		// Code 2
		PdfContentByte cb = writer.getDirectContent();
		PdfOutline root = cb.getRootOutline();

		// Code 3
		@SuppressWarnings("unused")
		PdfOutline oline1 = new PdfOutline(root, PdfAction.gotoLocalPage("1",
				false), "Chapter 1");

		PdfOutline oline2 = new PdfOutline(root, PdfAction.gotoLocalPage("2",
				false), "Chapter 2");
		oline2.setOpen(false);

		@SuppressWarnings("unused")
		PdfOutline oline2_1 = new PdfOutline(oline2, PdfAction.gotoLocalPage(
				"2.1", false), "Sub 2.1");
		@SuppressWarnings("unused")
		PdfOutline oline2_2 = new PdfOutline(oline2, PdfAction.gotoLocalPage(
				"2.2", false), "Sub 2.2");

		@SuppressWarnings("unused")
		PdfOutline oline3 = new PdfOutline(root, PdfAction.gotoLocalPage("3",
				false), "Chapter 3");
		// 设置目录结束
		
		

		// 生成Barcode QRCode
		String myString = "http://www.baidu.com";

		Barcode128 code128 = new Barcode128();
		code128.setCode(myString.trim());
		code128.setCodeType(Barcode128.CODE128);
		Image code128Image = code128.createImageWithBarcode(cb, BaseColor.GREEN, BaseColor.RED);
		code128Image.setAbsolutePosition(100, 300);
		code128Image.scalePercent(125);
		doc.add(code128Image);

		BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);
		Image qrcodeImage = qrcode.getImage();
		qrcodeImage.setAbsolutePosition(100, 200);
		qrcodeImage.scalePercent(200);
		doc.add(qrcodeImage);
		
		//最后关闭文件
		doc.close();
	}

}
