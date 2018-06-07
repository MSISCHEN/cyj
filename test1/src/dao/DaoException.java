package dao;

/**
 * Created by Administrator on 2017/12/22.
 */
public class DaoException extends RuntimeException {
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException() {

    }
}
