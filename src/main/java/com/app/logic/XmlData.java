package com.app.logic;

import com.app.model.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cooler on 15.01.2015.
 */
public class XmlData {
    private XmlData() throws IOException {
    }

    public static Project readFromFile(String filePath) {
        Project project = null;

        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            project = (Project) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return project;
    }

    public static void writeToFile(Project project, String filePath) {
        if (project == null) {
            return;
        }

        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(project, file);
            jaxbMarshaller.marshal(project, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
