package com.javaclub.demo.plantumlgenerator.infrastructure.rest;

import de.elnarion.util.plantuml.generator.classdiagram.PlantUMLClassDiagramGenerator;
import de.elnarion.util.plantuml.generator.classdiagram.config.PlantUMLClassDiagramConfigBuilder;
import de.elnarion.util.plantuml.generator.sequencediagram.PlantUMLSequenceDiagramGenerator;
import de.elnarion.util.plantuml.generator.sequencediagram.config.PlantUMLSequenceDiagramConfigBuilder;
import de.elnarion.util.plantuml.generator.sequencediagram.exception.NotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TweetsControllerPlantUmlTest {

    @Test
    void plantUMLSequenceDiagram() throws NotFoundException, IOException {

        // ARRANGE
        PlantUMLSequenceDiagramConfigBuilder builder = new PlantUMLSequenceDiagramConfigBuilder(
            TweetsController.class.getName(),
            "recommendations");
        PlantUMLSequenceDiagramGenerator generator = new PlantUMLSequenceDiagramGenerator(builder
//            .withUseShortClassName()
            .withIgnoreJPAEntities(true)
            .withShowReturnTypes(true)
            .build());

// ACT
        String generatedDiagram = generator.generateDiagramText();
        Files.writeString(Path.of("./PlantUMLSequenceDiagram.puml"), generatedDiagram);

    }

    @Test
    void plantUMLClassDiagram() throws IOException {

        List<String> scanPackages = new ArrayList<>();
        scanPackages.add("com.javaclub.demo.plantumlgenerator");
//        List<String> hideClasses = new ArrayList<>();
//        hideClasses.add("com.javaclub.demo.plantumlgenerator");
        PlantUMLClassDiagramConfigBuilder configBuilder = new PlantUMLClassDiagramConfigBuilder(scanPackages)
            .withHideMethods(true)
            .withJPAAnnotations(false)
            ;
//            .withHideClasses(hideClasses);
        PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(configBuilder.build());
        String result = generator.generateDiagramText();
        Files.writeString(Path.of("./plantUMLClassDiagram.puml"), result);

    }

}