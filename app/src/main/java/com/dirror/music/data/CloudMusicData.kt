package com.dirror.music.data

import com.dirror.music.music.standard.data.StandardSongData
import com.google.gson.annotations.SerializedName

// 登录数据
data class LoginData(
    val code: Int,
    val profile: ProfileData,
)

// 详细用户信息
data class UserDetailData(
    val level: Int, // 用户等级
    val code: Int?, // 参数，一般为错误代码，可能是空
    val profile: ProfileData?,
)

// 用户简单信息
data class ProfileData(
    val nickname: String,
    val userId: Int,
    val avatarUrl: String, // 头像
    val follows: Int, // 关注
    val followeds: Int, // 粉丝
)

data class UserPlaylistData(
    @SerializedName("playlist") val playlist: ArrayList<PlaylistData>
)

data class PlaylistData(
    @SerializedName("coverImgUrl") val coverImgUrl: String, // 歌单图片
    @SerializedName("name") val name: String, // 歌单名称
    @SerializedName("trackCount") val trackCount: Int, // 歌单歌曲数量
    @SerializedName("id") val id: Long, // 歌单 id
)

data class DetailPlaylistData(
    @SerializedName("code") val code: Int,
    @SerializedName("playlist") val playlist: DetailPlaylistInnerData?
)

data class DetailPlaylistInnerData(
    @SerializedName("tracks") val tracks: List<TracksData>,
    @SerializedName("trackIds") val trackIds: List<TrackIdsData>,
    @SerializedName("coverImgUrl") val coverImgUrl: String?, // 歌单图片
    @SerializedName("name") val name: String?, // 歌单名字
    @SerializedName("description") val description: String?, // 描述
)

data class TracksData(
    val name: String, // 歌曲名称
    val id: Long, // 歌曲 id
)

data class TrackIdsData(
    val id: Long, // 歌曲 id
)

data class SongData(
    val songs: List<SongInnerData>
)

data class SongInnerData(
    val name: String?,
    val id: Long,
    val ar: ArrayList<StandardSongData.StandardArtistData>,
    val al: AlbumData,
)

data class AlbumData( // 专辑
    val picUrl: String
)

data class ArtistData(
    val name: String
)



// 搜索结果
data class SearchData(
    val result: SearchResultData
)
data class SearchResultData(
    val songs: List<SearchSongData>
)

data class SearchSongData(
    val id: Long,
)

// 歌曲评论
data class CommentData(
    val hotComments: List<HotComment>, // 热门评论
    val total: Long // 总评论
)

data class HotComment(
    val user: CommentUser,
    val content: String, // 评论内容
    val time: Long, // 评论时间
    val likedCount: Long // 点赞数
)

data class CommentUser(
    val avatarUrl: String, // 头像
    val nickname: String, // 昵称
    val userId: Long //
)