package net.rugmj.logicalredstone;

public class StateManager {

    private static boolean autoDustEnabled;
    public static boolean getAutoDustState() {return autoDustEnabled;}
    public static void toggleAutoDustState() {autoDustEnabled = !autoDustEnabled;}

}
