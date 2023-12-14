package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{

    public ErrorDataResult(T data, String message) {
        //true-> success dönüş tipi
        super(data, false,message);
    }

    public ErrorDataResult(T data){
        super(data,false);
    }

    public ErrorDataResult( String message) {
        //true-> success dönüş tipi
        super(null, false,message);
    }

    public ErrorDataResult() {
        //true-> success dönüş tipi
        super(null, false);
    }
}
