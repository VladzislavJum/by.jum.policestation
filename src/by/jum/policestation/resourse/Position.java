package by.jum.policestation.resourse;

public enum Position {
    BULLET_OUT(160),
    FIRST_BOX_POSITION(180),
    CAR_OUT(740),
    NEXT_BOX_DIFF(200);

    private int position;

    Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}