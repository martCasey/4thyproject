from django.conf.urls import *
from polls import views
urlpatterns = [
	url(r'^$', views.index, name='index'),
]



#from django.conf.urls import *
#from django.contrib import admin

#urlpatterns = [
#	url(r'^polls/', include('polls.urls')),	#reads the polls folder, then includes urls from #		urls.py file
#	url(r'^admin/', include(admin.site.urls)),
#]
