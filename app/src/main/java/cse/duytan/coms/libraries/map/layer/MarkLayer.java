package cse.duytan.coms.libraries.map.layer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;


import java.util.ArrayList;
import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.libraries.map.MapView;
import cse.duytan.coms.libraries.map.utils.MapMath;
import cse.duytan.coms.models.ConferenceLocation;
import cse.duytan.coms.untils.Utils;

/**
 * MarkLayer
 *
 * @author: onlylemi
 */
public class MarkLayer extends MapBaseLayer {

    //  private List<PointF> marks;
    // private List<String> marksName;
    private ArrayList<ConferenceLocation> listLocation;
    private MarkIsClickListener listener;

    private Bitmap bmpMark, bmpMarkTouch;

    private float radiusMark;
    private boolean isClickMark = false;
    private int num = -1;

    private Paint paint;

    public MarkLayer(MapView mapView) {
        this(mapView, null);
    }

//    public MarkLayer(MapView mapView, List<PointF> marks, List<String> marksName) {
//        super(mapView);
//        this.marks = marks;
//        this.marksName = marksName;
//
//        initLayer();
//    }

    public MarkLayer(MapView mapView, ArrayList<ConferenceLocation> listLocation) {
        super(mapView);
        this.listLocation = listLocation;
        initLayer();
    }

    private void initLayer() {
        radiusMark = setValue(10f);

        bmpMark = BitmapFactory.decodeResource(mapView.getResources(), R.mipmap.mark);
//        bmpMarkTouch = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.ic_location);
        bmpMarkTouch = Utils.getBitmapFromVectorDrawable(mapView.getContext(), R.drawable.ic_location);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

//    @Override
//    public void onTouch(MotionEvent event) {
//        listener.markIsClick(0, event.getX(), event.getY());
//        if (marks != null) {
//            if (!marks.isEmpty()) {
//                float[] goal = mapView.convertMapXYToScreenXY(event.getX(), event.getY());
//                for (int i = 0; i < marks.size(); i++) {
//                    if (MapMath.getDistanceBetweenTwoPoints(goal[0], goal[1],
//                            marks.get(i).x - bmpMark.getWidth() / 2, marks.get(i).y - bmpMark
//                                    .getHeight() / 2) <= 50) {
//                        num = i;
//                        isClickMark = true;
//                        break;
//                    }
//
//                    if (i == marks.size() - 1) {
//                        isClickMark = false;
//                    }
//                }
//            }
//
//            if (listener != null && isClickMark) {
//                listener.markIsClick(num);
//                mapView.refresh();
//            }
//        }
//    }

    @Override
    public void onTouch(MotionEvent event) {
        listener.markIsClick(0, event.getX(), event.getY());
        if (listLocation != null) {
            if (!listLocation.isEmpty()) {
                float[] goal = mapView.convertMapXYToScreenXY(event.getX(), event.getY());
                int size = listLocation.size();
                for (int i = 0; i < size; i++) {
                    if (MapMath.getDistanceBetweenTwoPoints(goal[0], goal[1],
                            listLocation.get(i).getLOCATION_LAT() - bmpMark.getWidth() / 2, listLocation.get(i).getLOCATION_LONG() - bmpMark
                                    .getHeight() / 2) <= 50) {
                        num = i;
                        isClickMark = true;
                        break;
                    }

                    if (i == size - 1) {
                        isClickMark = false;
                    }
                }
            }

            if (listener != null && isClickMark) {
                listener.markIsClick(num);
                mapView.refresh();
            }
        }
    }

//    @Override
//    public void draw(Canvas canvas, Matrix currentMatrix, float currentZoom, float
//            currentRotateDegrees) {
//        if (isVisible && marks != null) {
//            canvas.save();
//            if (!marks.isEmpty()) {
//                for (int i = 0; i < marks.size(); i++) {
//                    PointF mark = marks.get(i);
//                    float[] goal = {mark.x, mark.y};
//                    currentMatrix.mapPoints(goal);
//
//                    paint.setColor(Color.BLACK);
//                    paint.setTextSize(radiusMark);
//                    //mark name
//                    if (mapView.getCurrentZoom() > 1.0 && marksName != null
//                            && marksName.size() == marks.size()) {
//                        canvas.drawText(marksName.get(i), goal[0] - radiusMark, goal[1] -
//                                radiusMark / 2, paint);
//                    }
//                    //mark ico
//                    canvas.drawBitmap(bmpMark, goal[0] - bmpMark.getWidth() / 2,
//                            goal[1] - bmpMark.getHeight() / 2, paint);
//                    if (i == num && isClickMark) {
//                        canvas.drawBitmap(bmpMarkTouch, goal[0] - bmpMarkTouch.getWidth() / 2,
//                                goal[1] - bmpMarkTouch.getHeight(), paint);
//                    }
//                }
//            }
//            canvas.restore();
//        }
//    }

    @Override
    public void draw(Canvas canvas, Matrix currentMatrix, float currentZoom, float
            currentRotateDegrees) {
        if (isVisible && listLocation != null) {
            canvas.save();
            if (!listLocation.isEmpty()) {
                int size = listLocation.size();
                for (int i = 0; i < size; i++) {
                    ConferenceLocation location = listLocation.get(i);
                    float[] goal = {location.getLOCATION_LAT(), location.getLOCATION_LONG()};
                    currentMatrix.mapPoints(goal);

                    paint.setColor(Color.BLACK);
                    paint.setTextSize(radiusMark);
                    //mark name
                    if (mapView.getCurrentZoom() > 1.0) {
                        canvas.drawText(location.getDESCRIPTION(), goal[0] - radiusMark, goal[1] -
                                radiusMark / 2, paint);
                    }
                    //mark ico
                    canvas.drawBitmap(bmpMark, goal[0] - bmpMark.getWidth() / 2,
                            goal[1] - bmpMark.getHeight() / 2, paint);
                    if (i == num && isClickMark) {
                        canvas.drawBitmap(bmpMarkTouch, goal[0] - bmpMarkTouch.getWidth() / 2,
                                goal[1] - bmpMarkTouch.getHeight(), paint);
                    }
                }
            }
            canvas.restore();
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

//    public List<PointF> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<PointF> marks) {
//        this.marks = marks;
//    }
//
//    public List<String> getMarksName() {
//        return marksName;
//    }
//
//    public void setMarksName(List<String> marksName) {
//        this.marksName = marksName;
//    }

    public ArrayList<ConferenceLocation> getListLocation() {
        return listLocation;
    }

    public void setListLocation(ArrayList<ConferenceLocation> listLocation) {
        this.listLocation = listLocation;
    }

    public boolean isClickMark() {
        return isClickMark;
    }

    public void setMarkIsClickListener(MarkIsClickListener listener) {
        this.listener = listener;
    }

    public interface MarkIsClickListener {
        void markIsClick(int num, float x, float y);

        void markIsClick(int num);
    }
}
