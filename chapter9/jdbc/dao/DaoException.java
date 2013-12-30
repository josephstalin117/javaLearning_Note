package dao;

/**
 * @author josephstalin Dao异常处理
 */
public class DaoException extends RuntimeException {

	/**
	 * 构造函数
	 */
	public DaoException() {
		super();
	}

	/**
	 * 方法重载
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * 还是重载
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 懒的打了。。。
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
