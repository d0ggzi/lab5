public class Address {

    private String zipCode; //Поле не может быть null
    private Location town; //Поле не может быть null

    public Address(String zipCode, Location town){
        super();
        this.zipCode = zipCode;
        this.town = town;
    }


    @Override
    public String toString(){
        return "zipCode=" + zipCode + ", расположение=" + town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Location getTown() {
        return town;
    }
}
