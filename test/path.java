import java.nio.file.*;

public class path {

    public static void main(String[] args) {

        Path p1 = Paths.get("/tmp/foo");
        System.out.println(p1);

        Path currentDir = Paths.get("..");
        System.out.println(currentDir.toAbsolutePath().normalize());
    }
}