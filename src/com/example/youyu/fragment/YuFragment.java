package com.example.youyu.fragment;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.youyu.CommentActivity;
import com.example.youyu.EatWishActivity;
import com.example.youyu.OldTimeyActivity;
import com.example.youyu.R;
import com.example.youyu.baseadapter.YuBaseAdapter;
import com.example.youyu.baseadapter.YuImageBaseAdapter;
import com.example.youyu.model.YuModel;
import com.example.youyu.util.AccessTokenKeeper;
import com.example.youyu.util.Constants;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class YuFragment extends Fragment {
	ListView listView;
	TextView top_tittle;
	YuBaseAdapter adapter;
	YuModel yuModel;
	ImageView top_imageview, yu_image, image_share, yu_comment;
	TextView text_name, text, text_number, top_title;
	TextView weather, yu_image_by, time;
	PopupWindow popupWindow;
	LayoutInflater inflater;
	LinearLayout title_layout;
	YuImageBaseAdapter imageBaseAdapter;
	List<View> views;
	View view;
	View yu_view;
	ViewPager viewPager;
	/**ViewPager左边和右边*/
	private EdgeEffectCompat leftEdge;
	private EdgeEffectCompat rightEdge;
	SsoHandler ssoHandler;
	/** 微博微博分享接口实例 */
	private IWeiboShareAPI mWeiboShareAPI = null;
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_yu, null);
		viewPager = (ViewPager) view.findViewById(R.id.viewpager_yu);
		mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(getActivity(), Constants.APP_KEY);
		mWeiboShareAPI.registerApp();
		loadView();
		return view;
	}

	@SuppressLint("InflateParams")
	private void loadView() {
		views = new ArrayList<View>();
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		for (int i = 0; i < 5; i++) {
			yu_view = inflater.inflate(R.layout.listview_yu, null);
			initView();
			yuModel = new YuModel();
			yuModel.getData();
			List<YuModel> list = yuModel.getList();
			yuModel = (YuModel) list.get(i);
			getData();
			views.add(yu_view);
		}
		lastOntouch();// 滑动到最后页跳转
		// 初始化Adapter
		imageBaseAdapter = new YuImageBaseAdapter(views);
		viewPager.setAdapter(imageBaseAdapter);
		viewPager.setCurrentItem(4);
		viewPager.setOnPageChangeListener(listener);
	}

	/*
	 * 初始化控件
	 */
	private void initView() {
		text = (TextView) yu_view.findViewById(R.id.yu_text);
		text_number = (TextView) yu_view.findViewById(R.id.yu_textnumber);
		text_name = (TextView) yu_view.findViewById(R.id.yu_text_tittle);
		title_layout = (LinearLayout) yu_view.findViewById(R.id.title_layout);
		weather = (TextView) yu_view.findViewById(R.id.yu_weather);
		time = (TextView) yu_view.findViewById(R.id.yu_date);
		image_share = (ImageView) yu_view.findViewById(R.id.yu_share);
		yu_image_by = (TextView) yu_view.findViewById(R.id.yu_image_by);
		yu_image = (ImageView) yu_view.findViewById(R.id.yu_image);
		yu_comment = (ImageView) yu_view.findViewById(R.id.yu_comment);
		yu_comment.setOnClickListener(clickListener);
		image_share.setOnClickListener(clickListener);
		yu_image.setOnClickListener(clickListener);
		title_layout.setOnClickListener(clickListener);
		text_name.setOnClickListener(clickListener);
	}

	@SuppressLint("SimpleDateFormat")
	private void getData() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		time.setText(dateFormat.format(date));
		text.setText(yuModel.getText());
		text_name.setText(yuModel.getText_name());
		text_number.setText("第" + yuModel.getText_number() + "篇");
		weather.setText("今日天气：" + yuModel.getWeather());
		yu_image_by.setText("photo by:Tristain Kwan");
	}

	/**
	 * 点击事件
	 */
	OnClickListener clickListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.yu_share:
				// 点击分享弹出
				popWindow();
				break;
			case R.id.share_weibo:
				// 分享到微博
				sharePicture();
				popupWindow.dismiss();
				break;
			case R.id.share_quxiao:
				// 取消分享 销毁弹出框
				popupWindow.dismiss();
				break;
			case R.id.yu_image:
				// 跳转到往期回顾
				intent = new Intent(getActivity(), OldTimeyActivity.class);
				startActivity(intent);
				break;
			case R.id.title_layout:
				// 跳转到吃货心愿单
				intent = new Intent(getActivity(), EatWishActivity.class);
				startActivity(intent);
				break;
			case R.id.yu_comment:
				// 跳转到评论列表
				intent = new Intent(getActivity(), CommentActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

	/*
	 * 点击分享出现popWindow
	 */
	@SuppressLint("InflateParams")
	public void popWindow() {
		inflater = LayoutInflater.from(getActivity());
		View view = inflater.inflate(R.layout.activity_yu_shaarepopupwindow,
				null);
		// 获取屏幕宽度
		WindowManager wm = getActivity().getWindowManager();
		@SuppressWarnings("deprecation")
		int width = wm.getDefaultDisplay().getWidth();
		final int height = view.findViewById(R.id.share_pop).getTop();
		popupWindow = new PopupWindow(view, width, 585, true);
		popupWindow.setAnimationStyle(R.style.AnimBottom);
		popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
		ImageView iv_cancle = (ImageView) view.findViewById(R.id.share_quxiao);
		ImageView iv_weibo = (ImageView) view.findViewById(R.id.share_weibo);
		iv_weibo.setOnClickListener(clickListener);
		iv_cancle.setOnClickListener(clickListener);
		view.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						popupWindow.dismiss();
					}
				}
				return true;
			}
		});
	}

	/**
	 * ViewPager滑动相应事件
	 */
	OnPageChangeListener listener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			if (leftEdge != null && !leftEdge.isFinished()) {// 到了最后一张并且还继续拖动，出现蓝色限制边条了
				// 跳转到往期回顾
				Log.i("tag", "onPageScrolled");
				Intent intent = new Intent(getActivity(),
						OldTimeyActivity.class);
				startActivityForResult(intent, 0);
			}
		}
	};

	private void lastOntouch() {
		try {
			Field leftEdgeField = viewPager.getClass().getDeclaredField(
					"mLeftEdge");
			Field rightEdgeField = viewPager.getClass().getDeclaredField(
					"mRightEdge");
			if (leftEdgeField != null && rightEdgeField != null) {
				leftEdgeField.setAccessible(true);
				rightEdgeField.setAccessible(true);
				leftEdge = (EdgeEffectCompat) leftEdgeField.get(viewPager);
				rightEdge = (EdgeEffectCompat) rightEdgeField.get(viewPager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private ImageObject getImageObj() {
		ImageObject imageObject=new ImageObject();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) yu_image.getDrawable();
        //设置缩略图。 注意：最终压缩过的缩略图大小不得超过 32kb。
        Bitmap  bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        imageObject.setImageObject(bitmap);
        return imageObject;
		// 发送请求信息到微博，唤起微博分享界面
	}
	/*
	 * 分享图片
	 */
	private void sharePicture(){
		// 1. 初始化微博的分享消息
		 WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
		 weiboMessage.imageObject=getImageObj();
		 // 2. 初始化从第三方到微博的消息请求
	        SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
	        // 用transaction唯一标识一个请求
	        request.transaction = String.valueOf(System.currentTimeMillis());
	        request.multiMessage = weiboMessage;
	        AuthInfo authInfo = new AuthInfo(getActivity(), Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
		    Oauth2AccessToken accessToken = AccessTokenKeeper.readAccessToken(getActivity());
		    String token = "";
		    if (accessToken != null) {
		        token = accessToken.getToken();
		    }
		    mWeiboShareAPI.sendRequest(getActivity(), request, authInfo, token, new WeiboAuthListener() {
		        
		        @Override
		        public void onWeiboException( WeiboException arg0 ) {
		        }
		        
		        @Override
		        public void onComplete( Bundle bundle ) {
		            // TODO Auto-generated method stub
		            Oauth2AccessToken newToken = Oauth2AccessToken.parseAccessToken(bundle);
		            AccessTokenKeeper.writeAccessToken(getActivity(), newToken);
		        }
		        
		        @Override
		        public void onCancel() {
		        }
		    });
		}
}
