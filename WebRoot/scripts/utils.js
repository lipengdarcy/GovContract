//浏览器相关信息
var Browser = {
    isIE: function () {
        return window.ActiveXObject ? true : false;
    },
    isChrome: function () {
        return navigator.userAgent.toLowerCase().indexOf("chrome") != -1
    },
    isSafari: function () {
        return navigator.userAgent.toLowerCase().indexOf("safari") != -1
    },
    isFirefox: function () {
        return navigator.userAgent.toLowerCase().indexOf("firefox") != -1
    },
    isOpera: function () {
        return navigator.userAgent.toLowerCase().indexOf("opera") != -1
    }
}

//事件操作
var Event = {
    addHandler: function (element, type, handler) {
        if (!element) {
            return;
        }
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, handler);
        } else {
            element["on" + type] = handler;
        }
    },
    getButton: function (event) {
        if (document.implementation.hasFeature("MouseEvents", "2.0")) {
            return event.button;
        } else {
            switch (event.button) {
                case 0:
                case 1:
                case 3:
                case 5:
                case 7:
                    return 0;
                case 2:
                case 6:
                    return 2;
                case 4: return 1;
            }
        }
    },
    getCharCode: function (event) {
        if (typeof event.charCode == "number") {
            return event.charCode;
        } else {
            return event.keyCode;
        }
    },
    getEvent: function (event) {
        return event ? event : window.event;
    },
    getRelatedTarget: function (event) {
        if (event.relatedTarget) {
            return event.relatedTarget;
        } else if (event.toElement) {
            return event.toElement;
        } else if (event.fromElement) {
            return event.fromElement;
        } else {
            return null;
        }

    },
    getTarget: function (event) {
        return event.target || event.srcElement;
    },
    preventDefault: function (event) {
        if (event.preventDefault) {
            event.preventDefault();
        } else {
            event.returnValue = false;
        }
    },
    removeHandler: function (element, type, handler) {
        if (element.removeEventListener) {
            element.removeEventListener(type, handler, false);
        } else if (element.detachEvent) {
            element.detachEvent("on" + type, handler);
        } else {
            element["on" + type] = null;
        }
    },
    stopPropagation: function (event) {
        if (event.stopPropagation) {
            event.stopPropagation();
        } else {
            event.cancelBubble = true;
        }
    }
};

//Ajax操作
var Ajax = {
    createXHR: function () {
        if (typeof XMLHttpRequest != "undefined") {
            return new XMLHttpRequest();
        } else if (typeof ActiveXObject != "undefined") {
            if (typeof arguments.callee.activeXString != "string") {
                var versions = ["MSXML2.XMLHttp.6.0", "MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp"];
                for (var i = 0, len = versions.length; i < len; i++) {
                    try {
                        var xhr = new ActiveXObject(versions[i]);
                        arguments.callee.activeXString = versions[i];
                        return xhr;
                    } catch (ex) {
                        alert("对不起出错了，请联系我们！");
                    }
                }
            }
            return new ActiveXObject(arguments.callee.activeXString);
        } else {
            throw new Error("没有有效的XHR对象！");
        }
    },
    parseParms: function (parms) {
        if (parms != null) {
            var array = new Array();
            for (var p in parms) {
                array.push(encodeURIComponent(p) + "=" + encodeURIComponent(parms[p]));
            }
            if (array.length > 0)
                return array.join("&");
        }
        return null;
    },
    get: function (url, cache, callback) {

        if (!cache) {
            url = url + (url.indexOf("?") == -1 ? "?" : "&")
            url = url + "ajaxTime=" + new Date();
        }

        var xhr = this.createXHR();
        if (callback) {
            xhr.onreadystatechange = function (event) {
                if (xhr.readyState == 4) {
                    if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                        callback(xhr.responseText);
                    } else {
                        ZENG.msgbox.show("请求出错,错误号为 [" + xhr.status + "]", 1, 3000);
                    }
                }
            }
        }
        xhr.open("get", url, true);
        xhr.send(null);
    },
    post: function (url, parms, cache, callback) {

        if (!cache) {
            url = url + (url.indexOf("?") == -1 ? "?" : "&")
            url = url + "ajaxTime=" + new Date();
        }

        var xhr = this.createXHR();
        if (callback) {
            xhr.onreadystatechange = function (event) {
                if (xhr.readyState == 4) {
                    if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                        callback(xhr.responseText);
                    } else {
                    	 ZENG.msgbox.show("请求出错,错误号为 [" + xhr.status + "]", 1, 3000);
                    }
                }
            }
        }
        xhr.open("post", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(this.parseParms(parms));
    }
}

//给firefox定义contains()方法
if (typeof (HTMLElement) != "undefined") {
    HTMLElement.prototype.contains = function (obj) {
        //通过循环对比来判断是不是obj的父元素
        while (obj != null && typeof (obj.tagName) != "undefind") {
            if (obj == this) return true;
            obj = obj.parentNode;
        }
        return false;
    };
}

//trim操作
function trim(val) {
    return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

//html编码
function htmlEncode(val) {
    return val.replace(/&/g, '&amp;').replace(/"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
}

//移除节点
function removeNode(node) {
    node.parentNode.removeChild(node)
}

//设置HTML元素属性
function setAttribute(o, a, v) {
    if (typeof o != 'object' || typeof a != 'string') return;
    a == 'class' ? o.className = v : o.setAttribute(a, v);
}

//获取HTML元素属性值
function getAttribute(o, a) {
    if (typeof o != 'object' || typeof a != 'string') return;
    return a == 'class' ? o.className : o.getAttribute(a);
}

//移除HTML元素属性
function removeAttribute(o, a) {
    if (typeof o != 'object' || typeof a != 'string') return;
    o.removeAttribute(a);
    if (a == 'class') o.removeAttribute('className');
}

//获取选中的单选框
function getSelectedRadio(radioList) {
    for (var i = 0, len = radioList.length; i < len; i++) {
        var radio = radioList[i];
        if (radio.checked) {
            return radio;
        }
    }
    return null;
}

//设置选中的单选框
function setSelectedRadio(radioList, value) {
    for (var i = 0, len = radioList.length; i < len; i++) {
        var radio = radioList[i];
        if (radio.value == value) {
            radio.checked = true;
            break;
        }
    }
}

//获取选中的选择项(单选)
function getSelectedOption(selectbox) {
    //return selectbox.options[selectbox.selectedIndex];
}

//获取选中的选择项(多选)
function getSelectedOptions(selectbox) {
    var result = new Array();
    var option = null;
    for (var i = 0, len = selectbox.options.length; i < len; i++) {
        option = selectbox.options[i];
        if (option.selected) {
            result.push(option);
        }
    }
    return result;
}

//设置选中的选择项
function setSelectedOptions(selectbox, value) {
    if (!selectbox) {
        return;
    }
    for (var i = 0, len = selectbox.options.length; i < len; i++) {
        var option = selectbox.options[i];
        if (option.value == value) {
            option.selected = true;
        }
        else {
            option.selected = false;
        }
    }
}

//移除选择框中全部的选择项
function removeAllOptions(selectbox) {
    if (!selectbox) {
        return;
    }
    for (var i = selectbox.options.length - 1; i >= 0; i--) {
        selectbox.options.remove(i);
    }
}

//读取cookie
function getCookie(name) {
    if (document.cookie.length > 0) {
        var cookieItemList = document.cookie.split(";");
        for (var i = 0; i < cookieItemList.length; i++) {
            var keyValuePair = cookieItemList[i].split("=");
            if (keyValuePair[0] = name) {
                return decodeURIComponent(keyValuePair[1]);
            }
        }
    }
    return ""
}

//设置cookie
function setCookie(name, value, expires) {
    var cookie = name + "=" + encodeURIComponent(value);
    if (expires != undefined && expires != null) {
        cookie += ";expires=" + expires;
    }
    document.cookie = cookie;
}

//删除cookie
function delCookie(name) {
    var expires = new Date();
    expires.setTime(expires.getTime() - 1);
    document.cookie = name + "=;expires=" + expires.toGMTString();
}

//判断是否是数字
function isNumber(val) {
    var regex = /^[\d|\.]+$/;
    return regex.test(val);
}

//判断是否为整数
function isInt(val) {
    var regex = /^\d+$/;
    return regex.test(val);
}

//判断是否为邮箱
function isEmail(val) {
    var regex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    return regex.test(email);
}

//判断是否为手机号
function isMobile(val) {
    var regex = /^[1][0-9][0-9]{9}$/;
    return regex.test(tel);
}

//验证密码
function verifyPassword() {
    var verifyPasswordForm = document.forms["verifyPasswordForm"];

    var act = verifyPasswordForm.elements["act"].value;
    var password = verifyPasswordForm.elements["password"].value;
    var verifyCode = verifyPasswordForm.elements["verifyCode"].value;

    if (password.length == 0) {
        alert("请输入密码");
        return;
    }
    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/verifypassword?act=" + act, { 'password': password, 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        if (result.state == "success") {
            window.location.href = result.content;
        }
        else {
            alert(result.content);
        }
    });
}

//发送验证手机短信
function sendVerifyMobile() {
    Ajax.get("/ucenter/sendverifymobile", false, function (data) {
        var result = eval("(" + data + ")");
        alert(result.content);
    });
}

//验证手机
function verifyMobile() {
    var verifyMobileForm = document.forms["verifyMobileForm"];

    var act = verifyMobileForm.elements["act"].value;
    var moibleCode = verifyMobileForm.elements["moibleCode"].value;
    var verifyCode = verifyMobileForm.elements["verifyCode"].value;

    if (moibleCode.length == 0) {
        alert("请输入短信验证码");
        return;
    }
    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/verifymobile?act=" + act, { 'moibleCode': moibleCode, 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        if (result.state == "success") {
            window.location.href = result.content;
        }
        else {
            alert(result.content);
        }
    });
}

//发送验证邮件
function sendVerifyEmail() {
    var sendVerifyEmailForm = document.forms["sendVerifyEmailForm"];

    var act = sendVerifyEmailForm.elements["act"].value;
    var verifyCode = sendVerifyEmailForm.elements["verifyCode"].value;

    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/sendverifyemail?act=" + act, { 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        alert(result.content);
    });
}

//更新密码
function updatePassword() {
    var updatePasswordForm = document.forms["updatePasswordForm"];

    var v = updatePasswordForm.elements["v"].value;
    var password = updatePasswordForm.elements["password"].value;
    var confirmPwd = updatePasswordForm.elements["confirmPwd"].value;
    var verifyCode = updatePasswordForm.elements["verifyCode"].value;

    if (password.length == 0) {
        alert("请输入密码");
        return;
    }
    if (password != confirmPwd) {
        alert("两次输入的密码不一样");
        return;
    }
    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/updatepassword?v=" + v, { 'password': password, 'confirmPwd': confirmPwd, 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        if (result.state == "success") {
            window.location.href = result.content;
        }
        else {
            alert(result.content);
        }
    });
}

//发送更新手机确认短信
function sendUpdateMobile() {
    var updateMobileForm = document.forms["updateMobileForm"];

    var v = updateMobileForm.elements["v"].value;
    var mobile = updateMobileForm.elements["mobile"].value;

    if (mobile.length == 0) {
        alert("请输入手机号");
        return;
    }

    Ajax.post("/ucenter/sendupdatemobile?v=" + v, { 'mobile': mobile }, false, function (data) {
        var result = eval("(" + data + ")");
        alert(result.content);
    });
}

//更新手机号
function updateMobile() {
    var updateMobileForm = document.forms["updateMobileForm"];

    var v = updateMobileForm.elements["v"].value;
    var mobile = updateMobileForm.elements["mobile"].value;
    var moibleCode = updateMobileForm.elements["moibleCode"].value;
    var verifyCode = updateMobileForm.elements["verifyCode"].value;

    if (mobile.length == 0) {
        alert("请输入手机号");
        return;
    }
    if (moibleCode.length == 0) {
        alert("请输入手机验证码");
        return;
    }
    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/updatemobile?v=" + v, { 'mobile': mobile, 'moibleCode': moibleCode, 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        if (result.state == "success") {
            window.location.href = result.content;
        }
        else {
            alert(result.content);
        }
    });
}

//发送更新邮箱确认邮件
function sendUpdateEmail() {
    var updateEmailForm = document.forms["updateEmailForm"];

    var v = updateEmailForm.elements["v"].value;
    var email = updateEmailForm.elements["email"].value;
    var verifyCode = updateEmailForm.elements["verifyCode"].value;

    if (email.length == 0) {
        alert("请输入邮箱");
        return;
    }
    if (verifyCode.length == 0) {
        alert("请输入验证码");
        return;
    }

    Ajax.post("/ucenter/sendupdateemail?v=" + v, { 'email': email, 'verifyCode': verifyCode }, false, function (data) {
        var result = eval("(" + data + ")");
        alert(result.content);
    });
}