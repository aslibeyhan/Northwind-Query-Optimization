package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data, String message) {
        //true-> success dönüş tipi
        super(data, true,message);
    }

    public SuccessDataResult(T data){
        super(data,true);
    }

    public SuccessDataResult( String message) {
        //true-> success dönüş tipi
        super(null, true,message);
    }

    public SuccessDataResult() {
        //true-> success dönüş tipi
        super(null, true);
    }
}
