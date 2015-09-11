package by.jum.policestation.path;

public enum Constant {
    TERRORIST("src/by/jum/policestation/resourse/image/man1.jpg"),
    CAR("src/by/jum/policestation/resourse/image/car2.jpg"),
    BULLET("src/by/jum/policestation/resourse/image/bullet.jpg"),
    POLICE_STATION("src/by/jum/policestation/resourse/image/police1.jpg");

    private String path;
    Constant(String path){
        this.path = path;
    }
    public String getPath(){
        return path;
    }
}
