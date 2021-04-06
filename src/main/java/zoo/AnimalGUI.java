package zoo;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class AnimalGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    String id = request.params(":animalID");
    Map<String, String> animals = new HashMap<>();
    String animalInfo = App.zoo.getWithID(id);
    animals.put("content", animalInfo);
    return new ModelAndView(animals, "index.ftl");
  }

}
