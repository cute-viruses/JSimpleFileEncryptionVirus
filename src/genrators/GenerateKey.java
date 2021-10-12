package genrators;

public class GenerateKey {
    private String key;

    /**
     * Generate key
     * @param length key length (size bits)
     */
    public GenerateKey(int length){
        setKey(generate((short)length));
    }

    private String generate(short length){
        // get Random numbers
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++)
            // get type (number or char)
            key.append((char)switch((int) (Math.random() * 2)){
                case 0 ->  (Math.random() * (57 - 48) + 48); // number
                case 1 ->  (Math.random() * ((i % 2 == 0? 90 : 122) - (i % 2 == 0? 65 : 97)) + (i % 2 == 0? 65 : 97)); // char
                default -> 65;
            });
        return key.toString();
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get the generated key
     * @return generated key
     */
    public String getKye(){
        return key;
    }
}
