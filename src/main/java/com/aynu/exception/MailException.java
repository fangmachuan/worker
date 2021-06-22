package com.aynu.exception;
/*RuntimeException不用处理（jvm会处理）
Exception 要自己手动处理
* */
public class MailException extends RuntimeException {
    public MailException(String error) {
        super(error);
    }
    public MailException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
