package com.olayinkapeter.dummyapi_test.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.olayinkapeter.dummyapi_test.R;
import com.olayinkapeter.dummyapi_test.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;
    private int rowLayout;
    private Context context;

    private OnUserItemClicked listener;

    public UserAdapter(List<User> users, int rowLayout, Context context) {
        this.users = users;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    // a view holder inner class where we get reference to the views in the layout using their ID
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_container)
        LinearLayout usersLayout;
        @BindView(R.id.email)
        TextView userEmail;
        @BindView(R.id.full_name)
        TextView fullName;
        @BindView(R.id.user_image)
        ImageView userImage;

        public UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        String fullName = users.get(position).getFirstName()
                + " " + users.get(position).getLastName()
                + " (" + users.get(position).getTitle()
                + ")";

        holder.userEmail.setText(users.get(position).getEmail());
        holder.fullName.setText(fullName);

        Glide.with(context).load(users.get(position).getPicture())
                .thumbnail(0.5f)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(24)))
                .into(holder.userImage);
        holder.userImage.setColorFilter(null);

        holder.usersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.containerClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setListener(OnUserItemClicked onUserItemClicked) {
        this.listener = onUserItemClicked;
    }

    public interface OnUserItemClicked {
        void containerClicked(int position);
    }
}