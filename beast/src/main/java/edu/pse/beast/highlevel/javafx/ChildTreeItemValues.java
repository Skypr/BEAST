package edu.pse.beast.highlevel.javafx;

import java.util.ArrayList;

import edu.pse.beast.propertychecker.Result;

public class ChildTreeItemValues {

	public final String propertyName;
	public final boolean checkBoxStatus;
	public final boolean disabled;
	public final AnalysisStatus status;
	
	public final ArrayList<Result> results;
	
	public ChildTreeItemValues(String propertyName, boolean checkBoxStatus, boolean disabled, AnalysisStatus status, ArrayList<Result> results) {
		this.propertyName = propertyName;
		this.checkBoxStatus = checkBoxStatus;
		this.disabled = disabled;
		this.status = status;
		
		this.results = results;
	}
}
