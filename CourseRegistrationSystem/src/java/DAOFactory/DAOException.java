/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

/**
 *
 * @author josephstalin
 */
public class DAOException extends RuntimeException {

    /**
     * 构造函数
     */
    public DAOException() {
        super();
    }

    /**
     * 方法重载
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public DAOException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 还是重载
     *
     * @param message
     * @param cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 懒的打了。。。
     *
     * @param message
     */
    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
