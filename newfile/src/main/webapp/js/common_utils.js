/**
 * html获取url上的参数，根据传入的name返回value
 * @param name
 * @returns
 */
function getUrlParam(name) {
   var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
   var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
   if (r != null) {
      return unescape(r[2]);
   }
   return null;
}