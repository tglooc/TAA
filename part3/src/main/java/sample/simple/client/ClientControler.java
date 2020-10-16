package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientControler {

	/**
	 * GET /create --> Create a new client and save it in the database.
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name) {
		String nom = "";
		try {
			Client client = new Client(name);
			clientDao.save(client);
			nom = String.valueOf(client.getNom());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "client succesfully created with id = " + nom;
	}

	@Autowired
	private ClientDao clientDao;

}