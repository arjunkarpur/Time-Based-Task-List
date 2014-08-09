package com.appsysstudios.timebasedtasklist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskListAdapter extends ArrayAdapter<Task> {

	int resource;
	String responses;
	Context context;

	public TaskListAdapter(Context context, int resource, ArrayList<Task> items) {
		super(context, resource, items);
		this.resource = resource;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout taskView;
		// Get the current alert object
		Task task = getItem(position);

		// Inflate the view
		if (convertView == null) {
			taskView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater layoutInflater;
			layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
			layoutInflater.inflate(resource, taskView, true);
		} else {
			taskView = (LinearLayout) convertView;
		}
		// Get the text boxes from the listitem.xml file
		TextView taskName = (TextView) taskView
				.findViewById(R.id.task_list_item_name);
		TextView taskTime = (TextView) taskView
				.findViewById(R.id.task_list_item_time);

		// Assign the appropriate data from our alert object above
		String timeMessage = task.getTaskTime() + " minute";
		
		taskName.setText(task.getTaskName());
		taskTime.setText(timeMessage);

		return taskView;
	}
	
	

}
