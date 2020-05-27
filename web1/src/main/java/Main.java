import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;
import servlets.ValueServlet;


public class Main {
    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet(); // создаем сервлет
        ValueServlet valueServlet = new ValueServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS); // создаем handler, для сервлета - контейнер
        context.addServlet(new ServletHolder(mainServlet), "/");// добавляем сервлет и говорим, при каком заголовке должен отвеать
        context.addServlet(new ServletHolder(valueServlet), "/mult");
        Server server = new Server(8080); // создание сервера
        server.setHandler(context); // передаем handler

        server.start();
        server.join();
    }
}
