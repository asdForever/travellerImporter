package kz.homework.travellerstaticcontentimporter.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileReaderService {

    private static final Log LOG = LogFactory.getLog(FileReaderService.class);

    public List<String> getLinesFromFile(String filename) {
        final File file;
        try {
            file = ResourceUtils.getFile("classpath:static/" + filename);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
            return new ArrayList<>();
        }

        try (final InputStream is = Files.newInputStream(file.toPath())) {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            LOG.error(e.getMessage());
            return new ArrayList<>();
        }
    }
}
