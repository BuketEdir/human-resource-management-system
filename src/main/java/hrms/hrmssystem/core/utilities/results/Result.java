package hrms.hrmssystem.core.utilities.results;

public class Result {

    //işlem başarılı falan bu tarz şeylerde bunu kullanıcaz
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess(){
        return this.success;
    }
    public String getMessage(){
        return this.message;
    }
}
