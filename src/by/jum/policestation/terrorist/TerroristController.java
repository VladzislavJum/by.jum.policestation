package by.jum.policestation.terrorist;

import javax.swing.JFrame;

public class TerroristController {
    private JFrame frame;
    private TerroristView terrorist;
    private TerroristModel terroristModel;

    public TerroristController(JFrame frame, TerroristView terrorist, TerroristModel terroristModel) {
        this.frame = frame;
        this.terrorist = terrorist;
        this.terroristModel = terroristModel;
    }

    public void addMovingTerrorist(){
        terroristModel.moveTerrorist(frame, terrorist);
    }
}
