package com.appsysstudios.timebasedtasklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AddNewTaskDialog extends DialogFragment {

	EditText newTaskName, newTaskTime;
	String newTaskNameString, newTaskTimeString;
	int newTaskTimeInt;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View inflator = inflater.inflate(R.layout.add_task_dialog, null);

		builder.setMessage(R.string.add_new_task);
		builder.setView(inflator);

		newTaskName = (EditText) inflator
				.findViewById(R.id.etAddTaskNamePrompt);
		newTaskTime = (EditText) inflator
				.findViewById(R.id.etAddTaskTimePrompt);

		builder.setPositiveButton(R.string.ok,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						newTaskNameString = newTaskName.getText().toString();
						newTaskTimeString = newTaskTime.getText().toString();

						if (newTaskNameString.length() == 0
								|| newTaskTimeString.length() == 0) {
							dialog.dismiss();
						} else if (newTaskNameString.length() == 0
								&& newTaskTimeString.length() == 0) {
							dialog.dismiss();
						} else {
							newTaskNameString = newTaskName.getText()
									.toString();
							newTaskTimeInt = Integer.parseInt(newTaskTime
									.getText().toString());
							Task newTask = new Task(newTaskNameString,
									newTaskTimeInt);
							((TaskListManager) getActivity())
									.addNewTaskToList(newTask);
							dialog.dismiss();
						}
					}
				});

		builder.setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});

		return builder.create();
	}

}
