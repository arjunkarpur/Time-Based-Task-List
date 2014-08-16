package com.appsysstudios.timebasedtasklist;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TaskListManager extends ActionBarActivity {

	ListView taskList;
	Button completeTasks;
	EditText minutesAvailable;

	// TaskListAdapter taskListAdapter;
	TaskListAdapter taskListAdapter;
	ArrayList<Task> taskArrayList = new ArrayList<Task>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_list_manager);

		initializeVars();
		populateList();
		taskListAdapter = new TaskListAdapter(TaskListManager.this,
				R.layout.task_list_item, taskArrayList);
		taskList.setAdapter(taskListAdapter);

	}

	public void populateList() {
		

	}

	private void initializeVars() {
		taskList = (ListView) findViewById(R.id.lvTasksList);
		completeTasks = (Button) findViewById(R.id.bAddNewTask);
		minutesAvailable = (EditText) findViewById(R.id.etMinutesAvailableEntered);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.task_manager_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.info_button:
			// do stuff
			return true;
		case R.id.add_task:
			DialogFragment newTaskDialog = new AddNewTaskDialog();
			newTaskDialog.show(getFragmentManager(), "AddNewTask");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void addNewTaskToList(Task newTask) {
		taskArrayList.add(newTask);
		taskListAdapter.notifyDataSetChanged();
	}
}
