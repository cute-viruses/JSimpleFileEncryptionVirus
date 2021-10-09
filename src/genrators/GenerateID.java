package genrators;

public class GenerateID {
    private String ID;

    public GenerateID(int length){
        setID(generate((short)length));
    }

    private String generate(short length){
        // get Random numbers
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++)
            key.append((char) (Math.random() * (57 - 48) + 48));
        return key.toString();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
