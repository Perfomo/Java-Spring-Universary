package ict.example.annotation;
import ict.example.annotation.domain.ClassDto;
import ict.example.annotation.domain.FieldDto;
import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
public class ClassCreator {
    private ClassCreator() {
    }
    public static void record(ClassDto classDto, ProcessingEnvironment environment) {
        JavaFileObject builderFile = null;
        try {
            builderFile = environment.getFiler().createSourceFile(classDto.getClassName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
            out.println("package " + classDto.getClassPackage() + ";");
            out.println();
            out.print("public class " + classDto.getClassName() + " {");
            out.println();
            out.println();
            generateNames(classDto.getFields(), out);
            out.println();
            out.println("}");
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void generateNames(Set<FieldDto> fields, PrintWriter out) {
        for (FieldDto field : fields) {
            out.println(" public static final String " + field.getFieldStringName() + " = \"" + field.getFieldName() + "\";");
        }
    }
}