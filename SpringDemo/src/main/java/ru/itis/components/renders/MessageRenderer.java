package ru.itis.components.renders;

import java.io.PrintWriter;

public interface MessageRenderer {
    void render();
    void printMessage(PrintWriter writer);
}
