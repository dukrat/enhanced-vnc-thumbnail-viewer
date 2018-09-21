/* *
 * Enhanced VNC Thumbnail Viewer 1.003
 *  - Fixed searching by use no case-sensitive
 * 
 * Enhanced VNC Thumbnail Viewer 1.000
 * Class for searching viewers in list
 */

public class SearchList{
    VncViewersList viewersList, viewersSearchList;
    
    public SearchList(EnhancedVncThumbnailViewer v){
        viewersSearchList = new VncViewersList(v);
    }
    
    public VncViewersList searchViewer(VncViewersList viewer,String searchText){
        viewersList = viewer;
        
        if(searchText == null || searchText.equals("")){
            return viewersList;
        }
        else{
            viewersSearchList.clear();
            CConnViewer v;
            for(int i = 0; i < viewersList.size(); i++){
                v = (CConnViewer) viewersList.get(i);
                if(v.compname.toLowerCase().contains(searchText.toLowerCase())){
                    viewersSearchList.add(v);
                }
            }        
            return viewersSearchList;
        }
    }
}