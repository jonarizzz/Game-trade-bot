package org.trade4life.core.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LogbackColorConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String level = event.getLevel().toString();

        if ("ERROR".equalsIgnoreCase(level)) {
            return "\u001B[31m" + level + "\u001B[0m"; // Red color for ERROR level
        } else if ("WARN".equalsIgnoreCase(level)) {
            return "\u001B[93m" + level + "\u001B[0m"; // Yellow color for WARN level
        } else if ("INFO".equalsIgnoreCase(level)) {
            return "\u001B[34m" + level + "\u001B[0m"; // Blue color for INFO level
        } else if ("DEBUG".equalsIgnoreCase(level)) {
            return "\u001B[32m" + level + "\u001B[0m"; // Green color for DEBUG level
        } else {
            return level; // Default color for other levels
        }
    }
}
