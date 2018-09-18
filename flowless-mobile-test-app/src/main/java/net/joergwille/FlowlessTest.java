package net.joergwille;


import org.fxmisc.flowless.Cell;
import org.fxmisc.flowless.VirtualFlow;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class FlowlessTest extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		ObservableList<String> items = FXCollections.observableArrayList();
		for (int i = 0; i < 20; ++i) {
			items.addAll("red", "green", "blue", "purple");
		}
		VirtualFlow<String, ?> flow = VirtualFlow.createVertical(items, color -> reg(color));
		Scene scene = new Scene(flow);
		
		primaryStage.setTitle("Flowless Mobile Test");
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Cell<String, Region> reg(String color) {
		Region reg = new Region() {
			@Override
			protected void layoutChildren() {
				super.layoutChildren();
			}
		};
		reg.setPrefHeight(16);
		reg.setStyle("-fx-background-color: " + color);
		return Cell.wrapNode(reg);
	}
}