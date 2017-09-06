package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Attendee;

/**
 * Created by Tuan Kiet on 7/4/2017.
 */

public class ListAttendeeAdapter extends RecyclerView.Adapter<ListAttendeeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Attendee> list;
    private String role, roleAdmin, roleReviewer, roleBoarOfReviewChar, roleAuthor, rolePresenter, roleAttendee, roleSupportStaff;


    public ListAttendeeAdapter(Context context, ArrayList<Attendee> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ListAttendeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_attendee, parent, false);
        return new ListAttendeeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAttendeeAdapter.ViewHolder holder, int position) {
        Attendee item = list.get(position++);
        holder.tvAvatar.setText(String.valueOf(item.getCurrentLastName().charAt(0))+String.valueOf(item.getCurrentFirstName().charAt(0)));
        holder.tvName.setText(item.getCurrentFullName());

        if (item.isConferenceAdminRight() == true){
            roleAdmin = "Admin, ";
        } else {roleAdmin = "";}
        if (item.isReviewerRight() == true){
            roleReviewer = "Reviewer, ";
        } else {roleReviewer = "";}
        if (item.isConferenceBoardOfReviewChairRight() == true){
            roleBoarOfReviewChar = "Board Of Reviewer Char, ";
        } else {roleBoarOfReviewChar = "";}
        if (item.isAuthorRight() == true){
            roleAuthor = "Author, ";
        } else {roleAuthor = "";}
        if (item.isPresenterRight() == true){
            rolePresenter = "Presenter, ";
        } else {rolePresenter = "";}
        if (item.isConferenceAttendeeRight() == true){
            roleAttendee = "Conference Attendee, ";
        } else {roleAttendee = "";}
        if (item.isSupportStaffRight() == true){
            roleSupportStaff = "Support Staff, ";
        } else {roleSupportStaff = "";}

        role = roleAdmin+roleReviewer+roleBoarOfReviewChar+roleAuthor+rolePresenter+roleAttendee+roleSupportStaff;
        if(role == null || role.length() == 0){
            role = "";
        }else {
            holder.tvRole.setText(role.substring(0, role.length() - 2));
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvColor, tvAvatar, tvName, tvRole;
        public ViewHolder(View itemView) {
            super(itemView);
            tvColor = (TextView) itemView.findViewById(R.id.tvColor);
            tvAvatar = (TextView) itemView.findViewById(R.id.tvAvatarAttendee);
            tvName = (TextView) itemView.findViewById(R.id.tvNameAttendee);
            tvRole = (TextView) itemView.findViewById(R.id.tvRoleAttendee);
        }
    }
}
