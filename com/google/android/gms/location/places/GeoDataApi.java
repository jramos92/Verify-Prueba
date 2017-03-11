package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

public abstract interface GeoDataApi
{
  public abstract PendingResult<PlaceBuffer> addPlace(GoogleApiClient paramGoogleApiClient, AddPlaceRequest paramAddPlaceRequest);
  
  public abstract PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient paramGoogleApiClient, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter);
  
  public abstract PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient paramGoogleApiClient, String... paramVarArgs);
  
  public abstract PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient paramGoogleApiClient, String paramString);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\GeoDataApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */