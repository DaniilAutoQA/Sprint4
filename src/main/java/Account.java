public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public  boolean checkNameToEmboss() {

        if (name == null){
            return false;
        }

        return name.matches("^\\S\\w*\\s{1}\\w{1,15}$");

    }

    @Override
    public String toString() {
        return
                '\'' + name + '\'';
    }
}
