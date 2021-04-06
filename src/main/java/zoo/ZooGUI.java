package zoo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ZooGUI implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    // TODO Auto-generated method stub
    QueryParamsMap params = request.queryMap();
    System.out.println(params.value("minage"));
    List<String> output = App.zoo.getAgeRange(params.value("minage"), params.value("maxage"));

    String toReturn = outputToHTML(output);
    Map<String, String> animals = new HashMap<>();
    animals.put("content", toReturn);
    return new ModelAndView(animals, "index.ftl");
  }

  public String outputToHTML(List<String> output) {
    StringBuilder builder = new StringBuilder();
    for (String element : output) {
      builder.append(element);
      builder.append("<br>");
    }
    return builder.toString();
  }

}
