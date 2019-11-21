package backend;

public class day {

    private menu one;
    private menu two;
    private menu three;


    public day(menu one, menu two, menu three){
        this.one=one;
        this.two=two;
        this.three=three;
    }

    public menu getOne() {
        return one;
    }

    public void setOne(menu one) {
        this.one = one;
    }

    public menu getTwo() {
        return two;
    }

    public void setTwo(menu two) {
        this.two = two;
    }

    public menu getThree() {
        return three;
    }

    public void setThree(menu three) {
        this.three = three;
    }


}
