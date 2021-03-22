package dasz;

import com.sun.net.httpserver.HttpServer;
import dasz.data.NamesService;
import dasz.model.GenderChecker;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

public class Application {

    public static void main(String[] args) throws IOException {
        int serverPort = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/start", (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                Map<String, List<String>> params = splitQuery(exchange.getRequestURI().getRawQuery());
                String noNameText = "No names given";
                String name = params.getOrDefault("name", List.of(noNameText)).stream().findFirst().orElse(noNameText);
                String defaultVariant = "allNames";
                String variant = params.getOrDefault(" variant", List.of(defaultVariant)).stream().findFirst().orElse(defaultVariant);
                String respText;
                if (name.equals("No names given")){
                    respText = name;
                }else {
                    GenderChecker genderChecker = new GenderChecker();
                    respText = String.valueOf(genderChecker.checkName(name, variant));
                }
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        server.createContext("/api/nameList", (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                NamesService namesService = new NamesService();
                String namesData = namesService.getNamesData();
                exchange.sendResponseHeaders(200, namesData.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(namesData.getBytes(StandardCharsets.UTF_8));
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static Map<String, List<String>> splitQuery(String query) {
        if (query == null || "".equals(query)) {
            return Collections.emptyMap();
        }

        return Pattern.compile("&").splitAsStream(query)
                .map(s -> Arrays.copyOf(s.split("="), 2))
                .collect(groupingBy(s -> decode(s[0]), mapping(s -> decode(s[1]), toList())));
    }

    private static String decode(final String encoded) {
        return encoded == null ? null : URLDecoder.decode(encoded, StandardCharsets.UTF_8);
    }
}
