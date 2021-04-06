package zoo;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class HomeGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    Map<String, String> animals = new HashMap<>();
    animals.put("content", "Welcome to the Zoo!");
    return new ModelAndView(animals, "index.ftl");
  }

}
