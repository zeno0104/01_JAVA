package edu.kh.network.server.run;

import edu.kh.network.server.model.service.ServerService;

public class ServerRun {
	public static void main(String[] args) {
		ServerService serverService = new ServerService();
		serverService.serverStart();

	}
}
