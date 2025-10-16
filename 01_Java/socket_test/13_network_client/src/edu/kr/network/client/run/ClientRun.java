package edu.kr.network.client.run;

import edu.kr.network.client.model.service.ClientService;

public class ClientRun {
	public static void main(String[] args) {
		ClientService clientService = new ClientService();
		clientService.clientStart();
	}
}
