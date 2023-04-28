package Command;

import Interface.ICommand;

public enum TemperatureCommand implements ICommand {
    LOWER,
    HIGHER,
    STANDARD
}
