package by.jum.policestation.resourse;

public enum PathImage {
    TERRORIST("src/by/jum/policestation/resourse/image/man1.jpg"),
    CAR("src/by/jum/policestation/resourse/image/car2.jpg"),
    BULLET("src/by/jum/policestation/resourse/image/bullet.jpg"),
    POLICE_STATION("src/by/jum/policestation/resourse/image/police1.jpg"),
    CAR_BOOM("src/by/jum/policestation/resourse/image/car3.jpg"),
    POLICE_ICON("src/by/jum/policestation/resourse/image/policeIcon.jpg");

    private String path;

    PathImage(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
