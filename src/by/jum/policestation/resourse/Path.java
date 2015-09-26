package by.jum.policestation.resourse;

public enum Path {
    TERRORIST("src/by/jum/policestation/resourse/image/man1.png"),
    CAR("src/by/jum/policestation/resourse/image/car2.png"),
    BULLET("src/by/jum/policestation/resourse/image/bullet.jpg"),
    POLICE_STATION("src/by/jum/policestation/resourse/image/police1.jpg"),
    CAR_BOOM("src/by/jum/policestation/resourse/image/boom.png"),
    POLICE_ICON("src/by/jum/policestation/resourse/image/policeIcon.jpg"),
    HEART_ICON("src/by/jum/policestation/resourse/image/heart.png"),
    BOOM_AUDIO("src/by/jum/policestation/resourse/boom.wav");

    private String path;

    Path(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
