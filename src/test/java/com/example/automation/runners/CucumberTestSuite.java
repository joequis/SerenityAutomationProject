package com.example.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.automation.stepdefinitions",
                "com.example.automation.Hooks"
        },
        plugin = {"pretty"},
        tags = "@demo"
)
public class CucumberTestSuite {

        private static String[] mavenCmdForOS() {
                String os = System.getProperty("os.name").toLowerCase();
                File mvnwWin = new File("mvnw.cmd");
                File mvnwNix = new File("mvnw");
                if (os.contains("win")) {
                        if (mvnwWin.exists()) return new String[]{"cmd", "/c", "mvnw.cmd", "serenity:aggregate"};
                        return new String[]{"cmd", "/c", "mvn.cmd", "serenity:aggregate"}; // fallback si tienes Maven instalado
                } else {
                        if (mvnwNix.exists()) return new String[]{"bash", "-lc", "./mvnw serenity:aggregate"};
                        return new String[]{"bash", "-lc", "mvn serenity:aggregate"}; // fallback a Maven del sistema
                }
        }

        @AfterClass
        public static void buildSerenityReport() {
                try {
                        // (Opcional) limpia solo el HTML anterior, NO borres resultados de pruebas
                        //deleteDir(new File("target/site/serenity"));

                        // Ejecuta el agregado del reporte con wrapper/Maven
                        String[] cmd = mavenCmdForOS();
                        ProcessBuilder pb = new ProcessBuilder(cmd);
                        pb.redirectErrorStream(true); // junta stdout+stderr para ver el log
                        Process p = pb.start();

                        // Muestra logs en consola
                        try (java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()))) {
                                String line;
                                while ((line = r.readLine()) != null) {
                                        System.out.println("[Serenity-aggregate] " + line);
                                }
                        }

                        int exit = p.waitFor();
                        System.out.println("[Serenity] aggregate terminó con exit code: " + exit);

                        // Abre el reporte si existe
                        openReport("target/site/serenity/index.html");
                } catch (Exception e) {
                        System.err.println("[Serenity] Error al agregar el reporte: " + e.getMessage());
                }
        }

        private static void openReport(String path) {
                try {
                        File reportFile = new File(System.getProperty("user.dir"), path); // ruta absoluta
                        if (!reportFile.exists()) {
                                System.err.println("[Serenity] Reporte no encontrado: " + reportFile.getAbsolutePath());
                                return;
                        }
                        // Usa Desktop si está soportado
                        if (java.awt.Desktop.isDesktopSupported()) {
                                java.awt.Desktop.getDesktop().browse(reportFile.toURI());
                                return;
                        }
                        // Fallback por OS
                        String os = System.getProperty("os.name").toLowerCase();
                        if (os.contains("win")) {
                                new ProcessBuilder("cmd", "/c", "start", "\"\"", reportFile.getAbsolutePath()).start();
                        } else if (os.contains("mac")) {
                                new ProcessBuilder("open", reportFile.getAbsolutePath()).start();
                        } else {
                                new ProcessBuilder("xdg-open", reportFile.getAbsolutePath()).start();
                        }
                } catch (Exception ignored) { }
        }
}
