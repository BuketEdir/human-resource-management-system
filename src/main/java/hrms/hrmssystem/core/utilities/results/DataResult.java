package hrms.hrmssystem.core.utilities.results;

public class DataResult<T> extends Result {

    //şu datayı göndermek istiyorum dediğimizde aynı zamanda resultı de extends etti
    //yani mesaj ve success bilgileri de gönderilicek içinde
    private T data;

    public DataResult(T data,boolean success, String message) {
        super(success, message); //süper resultın constructure larını set ediyor isSuccess ve message
        this.data=data;
    }

    public DataResult(T data,boolean success) {
        super(success);
        this.data=data;
    }
    public T getData(){
        return this.data;
    }
}
