package readtextfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Created by sca820 on 21 okt., 2022
 */
public class ResourceReader {
    /**
     * Get the content of a resource as a string
     *
     * @param name   the name of the resource if it is located in the
     *               same package as the calling class. The absolute name if it is located
     *               in another package.
     *               <p>
     *               Examples:
     *               The resource foo.txt is in the same package as
     *               the calling class, use the name <code>foo.txt</code>
     *               The resource bar.tst is in a different package
     *               than the calling class, use the name
     *               <code>/se/telia/tac/foo/bar.txt</code>
     * @param caller the calling class is used to get the proper class
     *               path to the resource
     * @return the content as a string
     */
    public String getResource(String name, Object caller) {
        try (InputStream resource = caller.getClass().getResourceAsStream(name)) {
            if (resource == null) {
                throw new RuntimeException("Can't read " + name);
            }

            return new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
